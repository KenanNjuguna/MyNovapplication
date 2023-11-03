package com.example.mynovapplication.ui.theme.Screen.Intents

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.provider.MediaStore
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

import com.example.mynovapplication.ui.theme.MyNovApplicationTheme

@Composable
fun IntentsScreen(navController: NavHostController){
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ){
        var context = LocalContext.current

        Button(onClick = {
            val uri = Uri.parse("smsto:0111263017")
            val intent = Intent(Intent.ACTION_SENDTO, uri)
            intent.putExtra("sms_body", "Hi there...")
            context.startActivity(intent)
        }) {
            Text(text = "SMS")
        }
        Button(onClick = {
            val emailIntent = Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "kenannjuguna8@gmail.com", null))
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "JOB APPLICATION")
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Dear sir ,following...")
            context.startActivity(Intent.createChooser(emailIntent, "Send email..."))

        }) {
            Text(text = "Email")
        }
        Button(onClick = {
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            ActivityCompat.startActivityForResult(context as Activity, takePictureIntent, 1,null)
        }) {
            Text(text = "Camera")
        }
        Button(onClick = {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Hey, download this app!")
            context.startActivity(shareIntent)
        }) {
            Text(text = "Share")
        }
        Button(onClick = {
            val simToolKitLaunchIntent: Intent = context.getPackageManager().getLaunchIntentForPackage("com.android.stk")!!
            if (simToolKitLaunchIntent != null) {
                context.startActivity(simToolKitLaunchIntent)
            }
        }) {
            Text(text = "Mpesa")
        }
        Button(onClick = {
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "0111263017"))
            if (ContextCompat.checkSelfPermission(
                    context,
                    Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    context as Activity,
                    arrayOf<String>(Manifest.permission.CALL_PHONE),
                    1
                )
            } else {
                context.startActivity(intent)
            }
        }) {
            Text(text = "call")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun IntentsScreenPreview(){
    MyNovApplicationTheme  {
        IntentsScreen(rememberNavController())
    }
}