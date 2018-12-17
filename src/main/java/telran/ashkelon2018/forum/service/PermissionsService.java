package telran.ashkelon2018.forum.service;

import java.util.Set;

import telran.ashkelon2018.forum.domain.Permission;

public interface PermissionsService {
	
	Permission addNewActionWithPermissions(Permission permission);
	
	Permission getPermissionsByAction(String action);
	
	Permission addPermissionsByAction(String action, Set<String> newRoles);
	
	Permission delPermissionsByAction(String action, Set<String> delRoles);
	
	Permission removeAction(String action);
	
}
