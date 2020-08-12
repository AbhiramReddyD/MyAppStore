package com.example.amandahinchman_dominguez.recyclerviews

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_main.*

data class Gram(val title: String, val desc: String, val Url: String)

class MainFragment : Fragment() {
    private var a: String = "abhiram.shuttercode"
    private val gramobjects = listOf(
        Gram(a, "Another day in Paradise.\n" +
                "-------------------------------------------------------------\n" +
                "In a beautiful morning, walking barefoot through the green fields with the company of the singing birds... and there you shall meet the real happiness!", "https://scontent-iad3-1.cdninstagram.com/v/t51.2885-15/e35/90089966_1291541564568514_1738448656677268799_n.jpg?_nc_ht=scontent-iad3-1.cdninstagram.com&_nc_cat=110&_nc_ohc=4SIxDaN02TwAX8RgRaG&oh=4bd82665f9fcc0ce752012a382d8340e&oe=5ECF551A"),
        Gram(a, "Where flowers bloom so does Hope.", "https://scontent-iad3-1.cdninstagram.com/v/t51.2885-15/e35/s1080x1080/90753503_514212792479838_6659633906735099928_n.jpg?_nc_ht=scontent-iad3-1.cdninstagram.com&_nc_cat=106&_nc_ohc=uEqozzpo08wAX8_-vyb&oh=ae6182e0ff079323b4b2055550b245b2&oe=5ECCC0A5"),
        Gram(a,"It's never too late to Learn.\n" +
                "Get yourself Cloud Ready on GCP with sessions and tutorials.","https://scontent-iad3-1.cdninstagram.com/v/t51.2885-15/e35/s1080x1080/90347358_208759303697872_4067282062264570029_n.jpg?_nc_ht=scontent-iad3-1.cdninstagram.com&_nc_cat=104&_nc_ohc=DJCkSg_znfAAX8lKw6E&oh=715a3199bb3d5e957261cfa50c50094e&oe=5ECE6C19"),
        Gram(a,"\uD83E\uDD8BWings Of Hope.....\uD83E\uDD8B","https://scontent-iad3-1.cdninstagram.com/v/t51.2885-15/e35/s1080x1080/89858791_841484856318859_7373112372139674977_n.jpg?_nc_ht=scontent-iad3-1.cdninstagram.com&_nc_cat=107&_nc_ohc=anjJV2zNj7IAX8PVOjD&oh=8d6f1f9d23b404ec82e73d432f7f7f18&oe=5ECFC360"),
        Gram(a,"Every sunset brings the promise of a new dawn. Remember there will always be tommorow.","https://scontent-iad3-1.cdninstagram.com/v/t51.2885-15/e35/s1080x1080/92823966_532651507418675_6352784496189769873_n.jpg?_nc_ht=scontent-iad3-1.cdninstagram.com&_nc_cat=111&_nc_ohc=zX7dfjZW3mMAX9rRj7e&oh=a9b6dc0d8a276a7dd63f8773b94ae597&oe=5ECC1266"),
        Gram(a,"\uD83E\uDD17\uD835\uDFE1\uD835\uDFDD\uD835\uDFDC \uD835\uDD44\uD835\uDD56\uD835\uDD5E\uD835\uDD60\uD835\uDD63\uD835\uDD5A\uD835\uDD56\uD835\uDD64 \uD835\uDD3E\uD835\uDD52\uD835\uDD5D\uD835\uDD60\uD835\uDD63\uD835\uDD56\uD83D\uDE0D\uD83D\uDE0F\uD83D\uDE02\uD83E\uDD26\u200D♂️","https://scontent-frt3-1.cdninstagram.com/v/t51.2885-15/sh0.08/e35/s750x750/66859595_472895796877825_4436741855527545236_n.jpg?_nc_ht=scontent-frt3-1.cdninstagram.com&_nc_cat=101&oh=d20c6f673acec8fd0ccc43585017158c&oe=5E785B8C&ig_cache_key=MjExODA0MjIxMzc0NDUxNjg5Mg%3D%3D.2")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.fragment_main, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list_recycler_view.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = ListAdapter(gramobjects)
        }
    }

    companion object {
        fun newInstance(): MainFragment = MainFragment()
    }
}