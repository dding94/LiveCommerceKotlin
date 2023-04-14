package com.flab.LiveCommerce.user.domain.exception

import com.flab.LiveCommerce.common.exception.ErrorCode
import com.flab.LiveCommerce.common.exception.SystemException

class UserPasswordNotMatchedException : SystemException {
    constructor() : super(ErrorCode.PASSWORD_NOT_MATCHED)
    constructor(message: String?, errorCode: ErrorCode?) : super(message, errorCode)
}
