package PageObjects;

public class EventsEndpointsPage{

    /*Endpoint Methods address
    Non public methods should be called through the bellow methods to get the
    method address with the parameter values already filled in*/

    public static String get_GetEvents = "/events";
    public static String post_CreateEvent = "/events";
    public static String post_ImportEvent = "/events/import";
    static String get_GetEventById = "/events/{eventId}";
    // TODO - Needs to clarifie duplicate endpoint functionality
    //static String put_UpdateEventMetadata = "/events/{eventId}";
    static String delete_DeleteEvent = "/events/{eventId}";
    static String get_GetEventACL = "/events/{eventId}/acl";
    static String put_UpdateEventACL = "/events/{eventId}/acl";
    static String post_GrantPermissionToACL = "/events/{eventId}/acl/{action}";
    static String delete_RemoveRoleFromACL = "/events/{eventId}/acl/{action}/{role}";
    static String get_GetEventMedia = "/events/{eventId}/media";
    static String get_GetEventMetadata = "/events/{eventId}/metadata";
    static String put_UpdateEventMetadata = "/events/{eventId}/metadata";
    static String delete_DeleteEventMetadata = "/events/{eventId}/metadata";
    static String get_GetEventPublications = "/events/{eventId}/publications";
    static String get_GetEventPublicationById = "/events/{eventId}/publications/{publicationId}";


    /*These methods allow the Endpoint addresses to be retrieved with
    the correct parameter values already filled in.*/

    public static String get_GetEventById(String eventId){
        return get_GetEventById.replace("{eventId}", eventId);
    }
    public static String delete_DeleteEvent(String eventId){
        return delete_DeleteEvent.replace("{eventId}", eventId);
    }
    public static String get_GetEventACL(String eventId){
        return get_GetEventACL.replace("{eventId}", eventId);
    }
    public static String put_UpdateEventACL(String eventId){
        return put_UpdateEventACL.replace("{eventId}", eventId);
    }
    public static String post_GrantPermissionToACL(String eventId, String action){
        return post_GrantPermissionToACL.replace("{eventId}", eventId).
                replace("{action}", action);
    }
    public static String delete_RemoveRoleFromACL(String eventId, String action, String role){
        return delete_RemoveRoleFromACL.replace("{eventId}", eventId).
                replace("{action}", action).
                replace("{role}", role);
    }
    public static String get_GetEventMedia(String eventId){
        return get_GetEventMedia.replace("{eventId}", eventId);
    }

    public static String get_GetEventMetadata(String eventId) {
        return get_GetEventMetadata.replace("{eventId}", eventId);
    }
    public static String put_UpdateEventMetadata(String eventId){
        return put_UpdateEventMetadata.replace("{eventId}", eventId);
    }
    public static String delete_DeleteEventMetadata(String eventId){
        return delete_DeleteEventMetadata.replace("{eventId}", eventId);
    }
    public static String get_GetEventPublications(String eventId){
        return get_GetEventPublications.replace("{eventId}", eventId);
    }
    public static String get_GetEventPublicationById(String eventId, String publicationId){
        return get_GetEventPublicationById.replace("{eventId}", eventId).
                replace("{publicationId}", publicationId);
    }
}