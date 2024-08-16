package com.example.composecalculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalculatorViewModel: ViewModel() {

    var state by mutableStateOf(CalculatorState())

    fun onAction(action: CalculatorActions) {
        when(action){
            is CalculatorActions.Number ->enterNumber(action.number)
            is CalculatorActions.Delete -> deletion()
            is CalculatorActions.Clear -> state = CalculatorState()
            is CalculatorActions.Operation ->enterOperation(action.operation)
            is CalculatorActions.Decimal ->enterDecimal()
            is CalculatorActions.Percentage ->enterPercentage()
            is CalculatorActions.Calculate -> calculate()
        }
    }

    private fun calculate() {
        val number1 = state.number1.toDoubleOrNull()
        val number2 = state.number2.toDoubleOrNull()
        if(number1 != null && number2 != null) {
            val result = when(state.operation) {
                is CalculatorOperation.Add -> number1 + number2
                is CalculatorOperation.Subtract -> number1 - number2
                is CalculatorOperation.Multiply -> number1 * number2
                is CalculatorOperation.Divide -> number1 / number2
                null -> return

            }
            state = state.copy(
                number1 = result.toString().take(15),
                number2 = "",
                operation = null
            )
        }
    }
    private fun deletion() {
        when{
            state.number2.isNotBlank() -> state = state.copy(
                number2 = state.number2.dropLast(1)
            )
            state.operation != null -> state = state.copy(
                operation = null
            )
            state.number1.isNotBlank() -> state =state.copy(
                number1 = state.number1.dropLast(1)
            )
        }
    }

    private fun enterOperation(operation: CalculatorOperation) {
        if(state.number1.isNotBlank()){
            state = state.copy(operation = operation)
        }
    }

    private fun enterDecimal() {
        if(state.operation == null && !state.number1.contains(".")
            && state.number1.isNotBlank()
            ){
            state = state.copy(
                number1 = state.number1 + "."
            )
            return
        } else if(!state.number2.contains(".") && state.number2.isNotBlank()
        ) {
            state = state.copy(
                number2 = state.number2 + "."
            )
        }
    }
    private fun enterPercentage() {
        if (state.operation == null && state.number1.isNotBlank()) {
            // Convert the first number to its percentage value
            val number1 = state.number1.toDoubleOrNull()
            if (number1 != null) {
                val percentageValue = number1 / 100
                state = state.copy(
                    number1 = percentageValue.toString()
                )
            }
        } else if (state.operation != null && state.number2.isNotBlank()) {
            // Apply percentage calculation relative to number1 and number2
            val number1 = state.number1.toDoubleOrNull()
            val number2 = state.number2.toDoubleOrNull()
            if (number1 != null && number2 != null) {
                val percentageValue = number1 * (number2 / 100)
                state = state.copy(
                    number2 = percentageValue.toString()
                )
            }
        }
    }


    private fun enterNumber(number: Int) {
        if(state.operation == null) {
            if(state.number1.length >= MAX_NUM_LENGTH) {
                return
            }
            state = state.copy(
                number1 = state.number1 + number
            )
            return
        }
        if(state.number2.length >= MAX_NUM_LENGTH) {
            return
        }
        state = state.copy(
            number2 = state.number2 + number
        )
    }

    companion object {
        private const val MAX_NUM_LENGTH = 15
    }
}