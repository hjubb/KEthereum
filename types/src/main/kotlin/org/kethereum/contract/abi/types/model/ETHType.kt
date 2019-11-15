package org.kethereum.contract.abi.types.model

import org.kethereum.contract.abi.types.PaginatedByteArray
import kotlin.reflect.KClass

interface ETHTypeParams {
    fun encodeToString(): String
}

data class ContractABITypeDefinition(
        val ethTypeKClass: KClass<out ETHType<*>>,
        val kotlinTypeKClass: KClass<*>,
        val params: ETHTypeParams? = null
)

interface ETHType<T> {
    val paddedValue: ByteArray
    fun toKotlinType(): T

    fun toPaged() = PaginatedByteArray(paddedValue)
}