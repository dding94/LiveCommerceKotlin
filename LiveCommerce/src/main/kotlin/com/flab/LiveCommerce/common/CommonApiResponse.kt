package com.flab.LiveCommerce.common

import com.flab.LiveCommerce.common.exception.ErrorCode

class CommonApiResponse<T>(val isSuccess: Boolean, val data: T, val error: Error?) {

    class Error(
        val code: String,
        val message: String,
    )

    companion object {
        fun <T> success(data: T): CommonApiResponse<T> {
            return CommonApiResponse(true, data, null)
        }

        fun <T> fail(error: Error?): CommonApiResponse<T?> {
            return CommonApiResponse(false, null, error)
        }

        fun <T> fail(errorCode: ErrorCode): CommonApiResponse<T?> {
            return CommonApiResponse(
                false, null, Error(errorCode.name, errorCode.message)
            )
        }

        fun <T> fail(code: String, message: String): CommonApiResponse<T?> {
            return CommonApiResponse(false, null, Error(code, message))
        }
    }
}
