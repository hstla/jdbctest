package example.dto;

public class Role {
  private Integer roleId;
  private String description;

  public Role(){}

  public Role(Integer roleId,String description){
    super();
    this.roleId=roleId;
    this.description=description;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getRoleId() {
    return roleId;
  }

  public void setRoleId(Integer roleId) {
    this.roleId = roleId;
  }

  @Override
  public String toString() {
    return "Role{" +
        "roleId=" + roleId +
        ", description='" + description + '\'' +
        '}';
  }
}
