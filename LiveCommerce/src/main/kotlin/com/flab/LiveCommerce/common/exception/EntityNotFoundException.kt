package com.flab.LiveCommerce.common.exception

class EntityNotFoundException : SystemException {
    constructor() : super(ErrorCode.COMMON_INVALID_PARAMETER)
    constructor(errorCode: ErrorCode) : super(errorCode)
}
