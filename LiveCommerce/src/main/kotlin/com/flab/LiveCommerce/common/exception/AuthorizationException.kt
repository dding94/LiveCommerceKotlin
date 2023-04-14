package com.flab.LiveCommerce.common.exception

class AuthorizationException : SystemException {
    constructor(errorCode: ErrorCode) : super(errorCode)
    constructor(message: String?, errorCode: ErrorCode?) : super(message, errorCode)
}
