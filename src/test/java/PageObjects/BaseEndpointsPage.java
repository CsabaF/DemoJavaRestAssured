package PageObjects;

public class BaseEndpointsPage {
    public static String get_Info = "/";
    public static String get_GetVersion = "/version";
    public static String get_GetDefaultVersion = "/version/default";
    public static String get_UserInfo = "/info/me";
    public static String get_UserRoles = "/info/me/roles";
    public static String get_CurrentOrganization = "/info/organization";
    public static String get_OrganizationProperties = "/info/organization/properties";
    public static String post_RepopulateExternalIndex = "/index/recreateIndex";
}
