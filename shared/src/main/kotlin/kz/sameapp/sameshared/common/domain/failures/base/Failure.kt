package kz.sameapp.sameshared.common.domain.failures.base

interface Failure {
    val code: Int
    val message: String
}