package com.example.movilesandroid

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricPrompt
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import com.example.movilesandroid.authentication.AuthView
import com.example.movilesandroid.navigation.MyAppNavigationView
import com.example.movilesandroid.ui.theme.MovilesAndroidTheme

class MainActivity : AppCompatActivity() {
    private var canAuthenticate = false
    private lateinit var promptInfo: BiometricPrompt.PromptInfo
    private lateinit var biometricPrompt: BiometricPrompt
    var isAuthenticated = mutableStateOf(false)

    private fun setUpAuth() {
        val biometricManager = BiometricManager.from(this)
        if (biometricManager.canAuthenticate(BiometricManager.Authenticators.BIOMETRIC_WEAK or BiometricManager.Authenticators.DEVICE_CREDENTIAL) == BiometricManager.BIOMETRIC_SUCCESS) {
            Log.d("MainActivity", "Puede autenticar")
            canAuthenticate = true
            promptInfo = BiometricPrompt.PromptInfo.Builder()
                .setTitle("Autenticación biométrica")
                .setSubtitle("Inicia sesión usando tu huella digital")
                .setAllowedAuthenticators(BiometricManager.Authenticators.BIOMETRIC_WEAK or BiometricManager.Authenticators.DEVICE_CREDENTIAL)
                .build()
            biometricPrompt = BiometricPrompt(
                this,
                ContextCompat.getMainExecutor(this),
                object : BiometricPrompt.AuthenticationCallback() {
                    override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                        super.onAuthenticationError(errorCode, errString)
                        Log.d("MainActivity", "onAuthenticationError: $errString ($errorCode)")

                    }

                    override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                        super.onAuthenticationSucceeded(result)
                        Log.d("MainActivity", "onAuthenticationSucceeded")

                        // Autenticación exitosa
                        handleAuthenticationResult(true)
                    }

                    override fun onAuthenticationFailed() {
                        super.onAuthenticationFailed()
                        // Autenticación fallida
                        Log.d("MainActivity", "onAuthenticationFailed")
                        handleAuthenticationResult(false)
                    }
                })
        } else {
            Log.d("MainActivity", "No puede autenticar")
            // Manejar el caso donde no se puede autenticar
        }
    }
    private fun handleAuthenticationResult(result: Boolean) {
        Log.d("MainActivity", "aquiii")
        isAuthenticated.value = result
    }
    fun authenticate(onAuthenticated: (Boolean) -> Unit) {
        if (canAuthenticate) {
            Log.d("MainActivity", "Intentando autenticar")
            biometricPrompt.authenticate(promptInfo)
        } else {
            // Manejar el caso donde no se puede autenticar
            Log.d("MainActivity", "No se puede autenticar")
            onAuthenticated(false)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpAuth()
        setContent {
            MovilesAndroidTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    //AuthView(isAuthenticated, onAuthenticated = ::handleAuthenticationResult)
                MyAppNavigationView()
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MovilesAndroidTheme {

    }
}
