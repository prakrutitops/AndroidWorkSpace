package com.example.module4assignments

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity6thque : AppCompatActivity()
{
    lateinit var btn:Button
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_6thque)

        btn=findViewById(R.id.internetcheck)
        btn.setOnClickListener {
            if (checkForInternet(this))
            {
                Toast.makeText(this,"Connected",Toast.LENGTH_LONG).show()
            }
            else
            {
                Toast.makeText(this,"Not Connected",Toast.LENGTH_LONG).show()
            }
        }
    }




            @SuppressLint("ServiceCast")
            private fun checkForInternet(context: Context): Boolean {

                // register activity with the connectivity manager service
                val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

                // if the android version is equal to M
                // or greater we need to use the
                // NetworkCapabilities to check what type of
                // network has the internet connection
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

                    // Returns a Network object corresponding to
                    // the currently active default data network.
                    val network = connectivityManager.activeNetwork ?: return false

                    // Representation of the capabilities of an active network.
                    val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false

                    return when {
                        // Indicates this network uses a Wi-Fi transport,
                        // or WiFi has network connectivity
                        activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true

                        // Indicates this network uses a Cellular transport. or
                        // Cellular has network connectivity
                        activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true

                        // else return false
                        else -> false
                    }
                } else {
                    // if the android version is below M
                    @Suppress("DEPRECATION") val networkInfo =
                        connectivityManager.activeNetworkInfo ?: return false
                    @Suppress("DEPRECATION")
                    return networkInfo.isConnected
                }
            }
        }

