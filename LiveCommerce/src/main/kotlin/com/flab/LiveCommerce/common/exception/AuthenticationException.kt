package com.flab.LiveCommerce.common.exception

class AuthenticationException : SystemException {
    constructor() : super(ErrorCode.UN_AUTHENTICATED)
    constructor(errorCode: ErrorCode) : super(errorCode)
    constructor(message: String?, errorCode: ErrorCode?) : super(message, errorCode)
}
