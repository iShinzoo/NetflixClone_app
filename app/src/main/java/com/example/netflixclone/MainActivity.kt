package com.example.netflixclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.netflixclone.ui.theme.NetflixCloneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black)
                    .verticalScroll(rememberScrollState())
            ){
                TopActionBar()
                NetflixContentChooser()
                FeatureMovieSection()
                addMovieList(movieType = "Watch It Again")
                addMovieList(movieType = "Latest Movies")
                addMovieList(movieType = "Action Movies")
                addMovieList(movieType = "Horror Movies")
                addMovieList(movieType = "Bollowood Movies")
                addMovieList(movieType = "HollyWood Movies")
            }
        }
    }

    @Composable
    @Preview
    fun TopActionBar(){
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .height(85.dp)
                .background(Color.Black),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(painter = painterResource(id = R.drawable.netflix_logo),
                contentDescription = "Logo",
                modifier = Modifier
                    .width(70.dp)
                    .padding(6.dp))

            Row (

            ){
                Image(painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = "Logo",
                    modifier = Modifier.padding(end = 12.dp))
                Image(painter = painterResource(id = R.drawable.ic_account),
                    contentDescription = "Logo",
                    modifier = Modifier.padding(end = 8.dp))
            }

        }
    }

    @Composable
    @Preview
    fun NetflixContentChooser(){
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
                .padding(vertical = 12.dp, horizontal = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(text = "TV Shows",
                color = Color.White,
                fontSize = 16.sp)
            Text(text = "Movies", color = Color.White,fontSize = 16.sp)
            Row {
                Text(text = "Categories", color = Color.White,fontSize = 16.sp)
                Image(painter = painterResource(id = R.drawable.ic_drop),
                    contentDescription = "drop")
            }
        }
    }

    @Composable
    @Preview
    fun FeatureMovieSection(){
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(painter = painterResource(id = R.drawable.m9), contentDescription = "",
                modifier = Modifier.padding(top = 40.dp))

            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 60.dp, start = 70.dp, end = 70.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(text = "Adventure", color = Color.White)
                Text(text = "Thriller", color = Color.White)
                Text(text = "Action", color = Color.White)
                Text(text = "Drama", color = Color.White)
            }

            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, start = 80.dp, end = 80.dp),
                horizontalArrangement = Arrangement.SpaceBetween

            ){
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Image(painter = painterResource(id = R.drawable.ic_add), contentDescription = "",
                        modifier = Modifier.size(30.dp))
                    Text(text = "My List", color = Color.White, fontSize = 10.sp)
                }

                Button(onClick = {},
                    colors = ButtonDefaults.buttonColors(Color.White),
                    shape = RoundedCornerShape(4.dp)) {
                    Text(text = "PLAY", color = Color.Black, fontSize = 18.sp)
                }
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Image(painter = painterResource(id = R.drawable.ic_info), contentDescription = "",
                        modifier = Modifier.size(30.dp))
                    Text(text = "info", color = Color.White, fontSize = 10.sp)
                }
            }
        }
    }

    @Composable
    fun addMovieList(movieType:String){

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
                .padding(top = 40.dp)
        ) {
            Text(text = movieType,
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 8.dp, bottom = 8.dp)
            )

            LazyRow{
                itemsIndexed(GetRandomMovieList()){
                    index, item ->
                    MovieSectionUI(imageRes = item.image)
                }
            }
        }
    }

    @Composable
    fun MovieSectionUI(
        imageRes : Int
    ){
        Image(painter = painterResource(id = imageRes),
            contentDescription = "",
            modifier = Modifier
                .padding(start = 3.dp, end = 3.dp, bottom = 5.dp)
                .height(170.dp)
                .width(130.dp))
    }

    fun GetRandomMovieList() : List<MovieSection>{
        val listofmovies = mutableListOf<MovieSection>()
        listofmovies.add(MovieSection(R.drawable.coming1))
        listofmovies.add(MovieSection(R.drawable.coming2))
        listofmovies.add(MovieSection(R.drawable.coming3))
        listofmovies.add(MovieSection(R.drawable.coming4))
        listofmovies.add(MovieSection(R.drawable.coming5))
        listofmovies.add(MovieSection(R.drawable.coming6))
        listofmovies.add(MovieSection(R.drawable.coming7))
        listofmovies.add(MovieSection(R.drawable.coming8))
        listofmovies.add(MovieSection(R.drawable.coming9))
        listofmovies.add(MovieSection(R.drawable.coming10))

        listofmovies.shuffle()

        return listofmovies
    }
}

data class MovieSection(
    val image : Int
)