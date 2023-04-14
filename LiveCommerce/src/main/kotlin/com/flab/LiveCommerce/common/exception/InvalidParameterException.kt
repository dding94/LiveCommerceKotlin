package com.flab.LiveCommerce.common.exception

class InvalidParameterException : SystemException {
    constructor() : super(ErrorCode.COMMON_INVALID_PARAMETER)
    constructor(message: String?) : super(message, ErrorCode.COMMON_INVALID_PARAMETER)
    constructor(errorCode: ErrorCode) : super(errorCode)
    constructor(message: String?, errorCode: ErrorCode?) : super(message, errorCode)
}
