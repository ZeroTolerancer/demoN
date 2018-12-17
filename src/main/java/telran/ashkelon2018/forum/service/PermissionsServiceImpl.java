package telran.ashkelon2018.forum.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import telran.ashkelon2018.forum.dao.PermissionsRepository;
import telran.ashkelon2018.forum.domain.Permission;
@Service
public class PermissionsServiceImpl implements PermissionsService {

	@Autowired
	PermissionsRepository permissionsRepository;
	
	
	@Override
	public Permission addNewActionWithPermissions(Permission permission) {
		
		return permissionsRepository.save(permission);
	}

	@Override
	public Permission getPermissionsByAction(String action) {
		return permissionsRepository.findById(action).orElse(null);
	}



	@Override
	public Permission removeAction(String action) {
		Permission perm = getPermissionsByAction(action);
		if(perm!=null) {
			permissionsRepository.deleteById(action);
		}
		return perm;
	}

	@Override
	public Permission addPermissionsByAction(String action, Set<String> newRoles) {
		Permission perm = getPermissionsByAction(action);
		if(perm!=null) {
			newRoles.forEach(role->perm.addAllowedRole(role));
			permissionsRepository.save(perm);
		}
		return perm;
	}

	@Override
	public Permission delPermissionsByAction(String action, Set<String> delRoles) {
		Permission perm = getPermissionsByAction(action);
		if(perm!=null) {
			delRoles.forEach(role->perm.deleteAllowedRole(role));
			permissionsRepository.save(perm);
		}
		return perm;
	}

}
