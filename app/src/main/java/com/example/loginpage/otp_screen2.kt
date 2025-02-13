import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
//import androidx.navigation.NavHostController
import com.example.loginpage.R


class otp_screen2() : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OtpScreen2(
                phoneNumber = "9891851352",
                onContinueClick = { otp -> println("OTP Entered: $otp") },
                onEditNumber = { println("Edit Number Clicked") }
            )        }
    }
}
@Composable
fun OtpScreen2(
    phoneNumber: String,
    onContinueClick: (String) -> Unit,
    onEditNumber: () -> Unit
) {
    var otpValue by remember { mutableStateOf("") }
    val maxLength = 4
    val isValidOtp = otpValue.length == maxLength

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(50.dp))

        Image(
            painter = painterResource(id = R.drawable.screenshot_2025_01_31_at_8_50_58_pm),
            contentDescription = "Logo",
            modifier = Modifier
                .size(120.dp)
                .padding(bottom = 40.dp)
        )

        Text(
            text = "Enter OTP",
            style = TextStyle(
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                fontFamily = FontFamily.SansSerif

            ),
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Row(
            modifier = Modifier.padding(bottom = 24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "OTP sent to $phoneNumber. ",
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color.Gray,
                    fontFamily = FontFamily.SansSerif

                )
            )
            TextButton(
                onClick = onEditNumber,
                contentPadding = PaddingValues(0.dp)
            ) {
                Text(
                    text = "Edit number",
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = Color(0xFF9333EA),
                        fontFamily = FontFamily.SansSerif

                    )
                )
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            repeat(maxLength) { index ->
                TextField(
                    value = if (index < otpValue.length) otpValue[index].toString() else "",
                    onValueChange = { },
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 4.dp)
                        .height(56.dp),
                    enabled = false,
                    textStyle = TextStyle(
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold
                    ),
                    colors = TextFieldDefaults.colors(
                        disabledTextColor = Color.Black,
                        disabledContainerColor = Color(0xFFF5F5F5),
                        disabledIndicatorColor = Color.Transparent
                    ),
                    shape = RoundedCornerShape(8.dp)
                )
            }
        }

        TextField(
            value = otpValue,
            onValueChange = {
                if (it.length <= maxLength && it.all { char -> char.isDigit() }) {
                    otpValue = it
                }
            },
            modifier = Modifier
                .size(0.dp)
                .background(Color.Transparent),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword)
        )

        TextButton(
            onClick = { },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text(
                text = "Didn't get the OTP? Resend SMS in 30s",
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color.Gray,
                    fontFamily = FontFamily.SansSerif

                )
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = {  },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF98389C)
            )
        ) {
            Text("Continue",
                fontFamily = FontFamily.SansSerif,
                color = Color.White
            )
        }

        Row(
            modifier = Modifier.padding(top = 16.dp, bottom = 16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "By continuing, you agree to our ",
                style = TextStyle(
                    fontSize = 12.sp,
                    color = Color.Gray,
                    fontFamily = FontFamily.SansSerif


                )
            )
            Text(
                text = "Terms and Conditions",
                style = TextStyle(
                    fontSize = 12.sp,
                    color = Color(0xFF9333EA),
                    fontFamily = FontFamily.SansSerif

                )
            )
        }
    }
}
//@Preview(showBackground = true)
//@Composable
//fun OtpScreenPreview2() {
//    OtpScreen2(
//        phoneNumber = "9891851352",
//        onContinueClick = {},
//        onEditNumber = {}
//    )
//}
