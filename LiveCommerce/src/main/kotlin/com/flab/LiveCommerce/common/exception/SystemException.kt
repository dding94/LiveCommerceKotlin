package com.flab.LiveCommerce.common.exception

open class SystemException : RuntimeException {
    private val errorCode: ErrorCode?

    constructor(errorCode: ErrorCode) : super(errorCode.message) {
        this.errorCode = errorCode
    }

    constructor(message: String?, errorCode: ErrorCode?) : super(message) {
        this.errorCode = errorCode
    }
}
