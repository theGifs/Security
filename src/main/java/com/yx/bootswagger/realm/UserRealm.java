package com.yx.bootswagger.realm;

import com.yx.bootswagger.domain.User;
import com.yx.bootswagger.service.PermissionService;
import com.yx.bootswagger.service.RoleService;
import com.yx.bootswagger.service.UserService;
import com.yx.bootswagger.utils.ActiverUser;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

//自定义realm
//@Component     犯了一个错误,当被springboot 管理时,注解应取消,因为他是被shiro 所管理的,!!!!!!!!
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;
    /**登陆
     * 认证的
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 得到用户名
        String userName = token.getPrincipal().toString();
        // 根据用户名查询用户
        User user = this.userService.queryUserByUserName(userName);
        if (null != user) {
            ActiverUser activerUser = new ActiverUser();
            // 设置用户
            activerUser.setUser(user);
            // 查询当前用户的角色
            activerUser.setRoles(this.roleService.queryRolesByUserId(user.getUserid()));
            // 查询当前用户的权限
            activerUser.setPermissions(this.permissionService.queryPermissionByUserId(user.getUserid()));
//          salt 盐值
            ByteSource credentialsSalt=ByteSource.Util.bytes(user.getUsername()+user.getAddress());
            AuthenticationInfo authorizationInfo = new SimpleAuthenticationInfo(activerUser, user.getUserpwd(),
                    credentialsSalt, getName());
            return authorizationInfo;
        } else {
            return null;
        }
    }
    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        获取用户认证后的信息,其中包含了 用户的角色,权限的信息,再用户访问的去查询
        ActiverUser activerUser=(ActiverUser) principals.getPrimaryPrincipal();
//        避免了再次查询数据库的消耗,或再后期使用缓存
        List<String> roles = activerUser.getRoles();
        List<String> permissions = activerUser.getPermissions();
//        授权
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        if(null!=roles&&roles.size()>0) {
//            添加此用户的角色信息

            info.addRoles(roles);
        }
        if(null!=permissions&&permissions.size()>0) {
//            权限的信息
            info.addStringPermissions(permissions);
        }
        return info;
    }



    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }

}
