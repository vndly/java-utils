package com.mauriciotogneri.javautils;

public class HttpStatus
{
    // 1xx Informational
    public static Integer CONTINUE = 100;
    public static Integer SWITCHING_PROTOCOLS = 101;
    public static Integer PROCESSING = 102;

    // 2xx Success
    public static Integer OK = 200;
    public static Integer CREATED = 201;
    public static Integer ACCEPTED = 202;
    public static Integer NON_AUTHORITATIVE_INFORMATION = 203;
    public static Integer NO_CONTENT = 204;
    public static Integer RESET_CONTENT = 205;
    public static Integer PARTIAL_CONTENT = 206;
    public static Integer MULTI_STATUS = 207;
    public static Integer ALREADY_REPORTED = 208;
    public static Integer IM_USED = 226;

    // 3xx Redirection
    public static Integer MULTIPLE_CHOICES = 300;
    public static Integer MOVED_PERMANENTLY = 301;
    public static Integer FOUND = 302;
    public static Integer SEE_OTHER = 303;
    public static Integer NOT_MODIFIED = 304;
    public static Integer USE_PROXY = 305;
    public static Integer TEMPORARY_REDIRECT = 307;
    public static Integer PERMANENT_REDIRECT = 308;

    // 4xx Client Error
    public static Integer BAD_REQUEST = 400;
    public static Integer UNAUTHORIZED = 401;
    public static Integer PAYMENT_REQUIRED = 402;
    public static Integer FORBIDDEN = 403;
    public static Integer NOT_FOUND = 404;
    public static Integer METHOD_NOT_ALLOWED = 405;
    public static Integer NOT_ACCEPTABLE = 406;
    public static Integer PROXY_AUTHENTICATION_REQUIRED = 407;
    public static Integer REQUEST_TIMEOUT = 408;
    public static Integer CONFLICT = 409;
    public static Integer GONE = 410;
    public static Integer LENGTH_REQUIRED = 411;
    public static Integer PRECONDITION_FAILED = 412;
    public static Integer REQUEST_ENTITY_TOO_LARGE = 413;
    public static Integer REQUEST_URI_TOO_LONG = 414;
    public static Integer UNSUPPORTED_MEDIA_TYPE = 415;
    public static Integer REQUESTED_RANGE_NOT_SATISFIABLE = 416;
    public static Integer EXPECTATION_FAILED = 417;
    public static Integer IAM_A_TEAPOT = 418;
    public static Integer ENHANCE_YOUR_CALM = 420;
    public static Integer UNPROCESSABLE_ENTITY = 422;
    public static Integer LOCKED = 423;
    public static Integer FAILED_DEPENDENCY = 424;
    public static Integer UPGRADE_REQUIRED = 426;
    public static Integer PRECONDITION_REQUIRED = 428;
    public static Integer TOO_MANY_REQUESTS = 429;
    public static Integer REQUEST_HEADER_FIELDS_TOO_LARGE = 431;
    public static Integer NO_RESPONSE = 444;
    public static Integer RETRY_WITH = 449;
    public static Integer UNAVAILABLE_FOR_LEGAL_REASONS = 451;
    public static Integer CLIENT_CLOSED_REQUEST = 499;

    // 5xx Server Error
    public static Integer INTERNAL_SERVER_ERROR = 500;
    public static Integer NOT_IMPLEMENTED_ = 501;
    public static Integer BAD_GETAWAT = 502;
    public static Integer SERVICE_UNAVAILABLE = 503;
    public static Integer GATEWAY_TIMEOUT = 504;
    public static Integer HTTP_VERSION_NOT_SUPPORTED = 505;
    public static Integer VARIANT_ALSO_NEGOTIATES = 506;
    public static Integer INSUFFICIENT_STORAGE = 507;
    public static Integer LOOP_DETECTED = 508;
    public static Integer BANDWIDTH_LIMIT_EXCEEDED = 509;
    public static Integer NOT_EXTENDED = 510;
    public static Integer NETWORK_AUTHENTICATION_REQUIRED = 511;
    public static Integer NETWORK_READ_TIMEOUT_ERROR = 598;
    public static Integer NETWORK_CONNECT_TIMEOUT_ERROR = 599;
}