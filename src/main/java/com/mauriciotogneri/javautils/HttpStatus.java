package com.mauriciotogneri.javautils;

public class HttpStatus
{
    // 1xx Informational
    public static final Integer CONTINUE = 100;
    public static final Integer SWITCHING_PROTOCOLS = 101;
    public static final Integer PROCESSING = 102;

    // 2xx Success
    public static final Integer OK = 200;
    public static final Integer CREATED = 201;
    public static final Integer ACCEPTED = 202;
    public static final Integer NON_AUTHORITATIVE_INFORMATION = 203;
    public static final Integer NO_CONTENT = 204;
    public static final Integer RESET_CONTENT = 205;
    public static final Integer PARTIAL_CONTENT = 206;
    public static final Integer MULTI_STATUS = 207;
    public static final Integer ALREADY_REPORTED = 208;
    public static final Integer IM_USED = 226;

    // 3xx Redirection
    public static final Integer MULTIPLE_CHOICES = 300;
    public static final Integer MOVED_PERMANENTLY = 301;
    public static final Integer FOUND = 302;
    public static final Integer SEE_OTHER = 303;
    public static final Integer NOT_MODIFIED = 304;
    public static final Integer USE_PROXY = 305;
    public static final Integer TEMPORARY_REDIRECT = 307;
    public static final Integer PERMANENT_REDIRECT = 308;

    // 4xx Client Error
    public static final Integer BAD_REQUEST = 400;
    public static final Integer UNAUTHORIZED = 401;
    public static final Integer PAYMENT_REQUIRED = 402;
    public static final Integer FORBIDDEN = 403;
    public static final Integer NOT_FOUND = 404;
    public static final Integer METHOD_NOT_ALLOWED = 405;
    public static final Integer NOT_ACCEPTABLE = 406;
    public static final Integer PROXY_AUTHENTICATION_REQUIRED = 407;
    public static final Integer REQUEST_TIMEOUT = 408;
    public static final Integer CONFLICT = 409;
    public static final Integer GONE = 410;
    public static final Integer LENGTH_REQUIRED = 411;
    public static final Integer PRECONDITION_FAILED = 412;
    public static final Integer REQUEST_ENTITY_TOO_LARGE = 413;
    public static final Integer REQUEST_URI_TOO_LONG = 414;
    public static final Integer UNSUPPORTED_MEDIA_TYPE = 415;
    public static final Integer REQUESTED_RANGE_NOT_SATISFIABLE = 416;
    public static final Integer EXPECTATION_FAILED = 417;
    public static final Integer IAM_A_TEAPOT = 418;
    public static final Integer ENHANCE_YOUR_CALM = 420;
    public static final Integer UNPROCESSABLE_ENTITY = 422;
    public static final Integer LOCKED = 423;
    public static final Integer FAILED_DEPENDENCY = 424;
    public static final Integer UPGRADE_REQUIRED = 426;
    public static final Integer PRECONDITION_REQUIRED = 428;
    public static final Integer TOO_MANY_REQUESTS = 429;
    public static final Integer REQUEST_HEADER_FIELDS_TOO_LARGE = 431;
    public static final Integer NO_RESPONSE = 444;
    public static final Integer RETRY_WITH = 449;
    public static final Integer UNAVAILABLE_FOR_LEGAL_REASONS = 451;
    public static final Integer CLIENT_CLOSED_REQUEST = 499;

    // 5xx Server Error
    public static final Integer INTERNAL_SERVER_ERROR = 500;
    public static final Integer NOT_IMPLEMENTED_ = 501;
    public static final Integer BAD_GATEWAY = 502;
    public static final Integer SERVICE_UNAVAILABLE = 503;
    public static final Integer GATEWAY_TIMEOUT = 504;
    public static final Integer HTTP_VERSION_NOT_SUPPORTED = 505;
    public static final Integer VARIANT_ALSO_NEGOTIATES = 506;
    public static final Integer INSUFFICIENT_STORAGE = 507;
    public static final Integer LOOP_DETECTED = 508;
    public static final Integer BANDWIDTH_LIMIT_EXCEEDED = 509;
    public static final Integer NOT_EXTENDED = 510;
    public static final Integer NETWORK_AUTHENTICATION_REQUIRED = 511;
    public static final Integer NETWORK_READ_TIMEOUT_ERROR = 598;
    public static final Integer NETWORK_CONNECT_TIMEOUT_ERROR = 599;
}