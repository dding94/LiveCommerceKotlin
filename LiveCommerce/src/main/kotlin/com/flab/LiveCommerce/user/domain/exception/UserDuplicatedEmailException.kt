package com.flab.LiveCommerce.user.domain.exception

import com.flab.LiveCommerce.common.exception.ErrorCode
import com.flab.LiveCommerce.common.exception.SystemException

class UserDuplicatedEmailException : SystemException {
    constructor() : super(ErrorCode.DUPLICATED_EMAIL)
    constructor(message: String?, errorCode: ErrorCode?) : super(message, ErrorCode.DUPLICATED_EMAIL)
}
