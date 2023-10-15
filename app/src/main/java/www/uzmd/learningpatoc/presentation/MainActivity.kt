package www.uzmd.learningpatoc.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.core.view.isInvisible
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import www.uzmd.learningpatoc.data.ApiCilent
import www.uzmd.learningpatoc.data.ApiSevices
import www.uzmd.learningpatoc.data.Model
import www.uzmd.learningpatoc.databinding.ActivityMainBinding
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.progressBar.isInvisible = true
        binding.infoBtn.setOnClickListener {
            binding.infoBtn.isEnabled = false
            binding.progressBar.isInvisible = false
            loadInfo ({
                if(it=="xato"){
                    Toast.makeText(this, "Url manzili noto`g`ri", Toast.LENGTH_SHORT).show()
                }else{
                    binding.url.text = it
                    binding.progressBar.isInvisible = true
                    binding.infoBtn.isEnabled = true
                }
            },binding.ytUtl.text.toString())
        }

    }

        private fun loadInfo(callback: (String) -> Unit,url:String) {
            thread {
                Thread.sleep(5000)
                Handler(Looper.getMainLooper()).post {
                    val apiSevices=ApiCilent.getRetrofit().create(ApiSevices::class.java)
                    apiSevices.getMusicUrl("https://youtu.be/3ipSnuGbPeE?si=a7tc5LeArudn2jfg").enqueue(object :Callback<Model>{
                        override fun onResponse(call: Call<Model>, response: Response<Model>) {
                            Log.e("TAG", "onResponse: ${response.body()?.link.toString()}", )
                            callback.invoke(response.body()?.link.toString())
                        }

                        override fun onFailure(call: Call<Model>, t: Throwable) {
                            callback.invoke("xato")
                        }

                    })
                }
            }
        }
    }