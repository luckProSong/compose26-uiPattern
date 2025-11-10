package com.example.uipatternstudy

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun IconItem(iconItem: IconItem) {
    Column(
        modifier = Modifier
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = DrawableUtil.getDrawableId(iconItem.image)),
            contentDescription = iconItem.label,
            modifier = Modifier.size(56.dp)
        )
        Spacer(Modifier.height(6.dp))
        Text(iconItem.label, fontSize = 13.sp)
    }
}

@Composable
fun IconsGrid(iconItems: List<IconItem>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(4),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp)
    ) {
        items(iconItems) { item ->
            IconItem(item)
        }
    }
}

@Composable
fun BannerCard(bannerItem: BannerItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 6.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF009688))
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = bannerItem.text,
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.weight(1f)
            )
            Image(
                painter = painterResource(id = DrawableUtil.getDrawableId(bannerItem.image)),
                contentDescription = null,
                modifier = Modifier.size(70.dp)
            )
        }
    }
}

@Composable
fun MainScreen(viewModel: MainViewModel = hiltViewModel()) {
    val mainData by viewModel.mainData.collectAsState()

    mainData?.let { data ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(top = 20.dp)
        ) {
            IconsGrid(data.icons)
            Spacer(Modifier.height(12.dp))
            data.banners.forEach { BannerCard(it) }
        }
    }
}