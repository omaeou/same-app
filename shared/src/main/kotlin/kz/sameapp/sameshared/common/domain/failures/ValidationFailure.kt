package kz.sameapp.sameshared.common.domain.failures

import kz.sameapp.sameshared.common.domain.failures.base.Failure

data class ValidationFailure (
    override val code: Int = 400,
    override val message: String = "Invalid input Parameters",
    val fieldMessages: List<FieldMessage>,
) : Failure {
    data class FieldMessage(
        val field: String,
        val message: String,
    )
}