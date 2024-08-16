package com.example.composecalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composecalculator.ui.theme.ComposeCalculatorTheme
import com.example.composecalculator.ui.theme.Cyan
import com.example.composecalculator.ui.theme.Green
import com.example.composecalculator.ui.theme.PurpleGrey40

@ExperimentalComposeUiApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            ComposeCalculatorTheme {
                val viewModel = viewModel<CalculatorViewModel>()
                val state = viewModel.state
                val buttonSpacing = 8.dp
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.BottomCenter),
                        verticalArrangement = Arrangement.spacedBy(buttonSpacing),
                    ) {
                        Text(
                            text = state.number1 + (state.operation?.symbol ?: ""),
                            textAlign = TextAlign.End,
                            modifier = Modifier
                                .fillMaxWidth(),
                            fontWeight = FontWeight.Light,
                            style = MaterialTheme.typography.headlineLarge,
                        )
                        Text(
                            text = state.number2,
                            textAlign = TextAlign.End,
                            modifier = Modifier
                                .fillMaxWidth(),
                            fontWeight = FontWeight.Light,
                            style = MaterialTheme.typography.headlineLarge,
                        )

                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                        ) {
                            AllClearButton(
                                symbol = "AC",
                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .weight(1f)
                                    .background(PurpleGrey40)
                            ) {
                                viewModel.onAction(CalculatorActions.Clear)
                            }
                            CalculatorButton(
                                symbol = "Del",
                                color = PurpleGrey40,
                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .weight(1f)
                            ) {
                                viewModel.onAction(CalculatorActions.Delete)
                            }
                            CalculatorButton(
                                symbol = "%" ,
                                color = PurpleGrey40,
                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .weight(1f)
                            ) {
                                viewModel.onAction(CalculatorActions.Percentage)
                            }
                            CalculatorButton(
                                symbol = "/",
                                color = Cyan,
                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .weight(1f)
                            ) {
                                viewModel.onAction(CalculatorActions.Operation(CalculatorOperation.Divide))
                            }
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                        ) {
                            CalculatorButton(
                                symbol = "7",
                                color = PurpleGrey40,
                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .weight(1f)
                            ) {
                                viewModel.onAction(CalculatorActions.Number(7))
                            }
                            CalculatorButton(
                                symbol = "8",
                                color = PurpleGrey40,
                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .weight(1f)
                            ) {
                                viewModel.onAction(CalculatorActions.Number(8))
                            }
                            CalculatorButton(
                                symbol = "9",
                                color = PurpleGrey40,
                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .weight(1f)
                            ) {
                                viewModel.onAction(CalculatorActions.Number(9))
                            }
                            CalculatorButton(
                                symbol = "x",
                                color = Cyan,
                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .weight(1f)
                            ) {
                                viewModel.onAction(CalculatorActions.Operation(CalculatorOperation.Multiply))
                            }
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                        ) {
                            CalculatorButton(
                                symbol = "4",
                                color = PurpleGrey40,
                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .weight(1f)
                            ) {
                                viewModel.onAction(CalculatorActions.Number(4))
                            }
                            CalculatorButton(
                                symbol = "5",
                                color = PurpleGrey40,
                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .weight(1f)
                            ) {
                                viewModel.onAction(CalculatorActions.Number(5))
                            }
                            CalculatorButton(
                                symbol = "6",
                                color = PurpleGrey40,
                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .weight(1f)
                            ) {
                                viewModel.onAction(CalculatorActions.Number(6))
                            }
                            CalculatorButton(
                                symbol = "-",
                                color = Cyan,
                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .weight(1f)
                            ) {
                                viewModel.onAction(CalculatorActions.Operation(CalculatorOperation.Subtract))
                            }
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                        ) {
                            CalculatorButton(
                                symbol = "1",
                                color = PurpleGrey40,
                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .weight(1f)
                            ) {
                                viewModel.onAction(CalculatorActions.Number(1))
                            }
                            CalculatorButton(
                                symbol = "2",
                                color = PurpleGrey40,
                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .weight(1f)
                            ) {
                                viewModel.onAction(CalculatorActions.Number(2))
                            }
                            CalculatorButton(
                                symbol = "3",
                                color = PurpleGrey40,
                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .weight(1f)
                            ) {
                                viewModel.onAction(CalculatorActions.Number(3))
                            }
                            CalculatorButton(
                                symbol = "+",
                                color = Cyan,
                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .weight(1f)
                            ) {
                                viewModel.onAction(CalculatorActions.Operation(CalculatorOperation.Add))
                            }
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                        ) {
                            CalculatorButton(
                                symbol = "0",
                                color = PurpleGrey40,
                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .weight(1f)
                            ) {
                                viewModel.onAction(CalculatorActions.Number(0))
                            }
                            CalculatorButton(
                                symbol = ".",
                                color = PurpleGrey40,
                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .weight(1f)
                            ) {
                                viewModel.onAction(CalculatorActions.Decimal)
                            }
                            ResultsButton(
                                symbol = "=",
                                modifier = Modifier
                                    .aspectRatio(2f)
                                    .weight(2f)
                                    .background(Green)
                            ) {
                                viewModel.onAction(CalculatorActions.Calculate)
                            }
                        }
                    }
                }
            }
        }
    }
}