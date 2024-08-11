package kz.sameapp.sameshared.common.domain.failures

import kz.sameapp.sameshared.common.domain.failures.base.Failure

class ServiceUnavailableFailure(
    override val code: Int = 500,
    override val message: String = "Service Unavailable",
) : Failure