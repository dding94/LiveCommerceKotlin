package com.flab.LiveCommerce.user.domain.exception

import com.flab.LiveCommerce.common.exception.ErrorCode
import com.flab.LiveCommerce.common.exception.SystemException

class InvalidTokenException : SystemException {
    constructor() : super(ErrorCode.INVALID_TOKEN)
    constructor(message: String?, errorCode: ErrorCode?) : super(message, errorCode)
}
