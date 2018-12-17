package telran.ashkelon2018.forum.domain;

import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@EqualsAndHashCode(of = {"action"})
@Document(collection = "forum_permissions")

public class Permission {
	@Id
	String action;
	Set<String> allowedRoles;
	
	public void addAllowedRole(String role) {
		allowedRoles.add(role);
	}
	
	public void deleteAllowedRole(String role) {
		allowedRoles.remove(role);
	}
	
}
