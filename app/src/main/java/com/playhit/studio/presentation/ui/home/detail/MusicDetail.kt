package com.playhit.studio.presentation.ui.home.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.playhit.studio.R
import com.playhit.studio.data.model.Track
import com.playhit.studio.presentation.theme.Studio100PercentTheme

@Composable
fun MusicDetail(modifier: Modifier = Modifier, model: Track? = null) {

    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        HorizontalDivider()
        Spacer(modifier = modifier.height(15.dp))
        Box(
            modifier = modifier
                .fillMaxWidth()
                .aspectRatio(1F)
                .padding(all = 20.dp)
        ) {
            AsyncImage(
                model = "${model?.album_image}",
                contentDescription = "Album image",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Icon(
                painter = painterResource(R.drawable.ic_heart_empty),
                contentDescription = "favorite",
                modifier = Modifier
                    .padding(top = 10.dp, end = 10.dp)
                    .size(25.dp)
                    .align(Alignment.TopEnd)
            )

            Column(
                modifier = modifier
                    .align(Alignment.BottomCenter)
                    .padding(vertical = 10.dp)
            ) {
                Text(
                    model?.name ?: "This Song",
                    modifier = modifier
                        .align(Alignment.CenterHorizontally),
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.bodyMedium.copy(color = Color.White)
                )

                Spacer(modifier = modifier.height(7.dp))

                Text(
                    model?.name ?: "This Song",
                    modifier = modifier
                        .align(Alignment.CenterHorizontally),
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.labelSmall.copy(color = colorResource(R.color.grey400))
                )

                Spacer(modifier = modifier.height(15.dp))

                Row(modifier = modifier.align(Alignment.CenterHorizontally)) {
                    IconButton(
                        onClick = {

                        }
                    ) {
                        Icon(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(all = 3.dp),
                            painter = painterResource(R.drawable.ic_rewind),
                            contentDescription = ""
                        )
                    }

                    Spacer(modifier = modifier.width(10.dp))

                    IconButton(
                        onClick = {

                        }
                    ) {
                        Icon(
                            modifier = Modifier
                                .fillMaxSize(),
                            painter = painterResource(R.drawable.ic_play),
                            contentDescription = ""
                        )
                    }

                    Spacer(modifier = modifier.width(10.dp))

                    IconButton(
                        onClick = {

                        }
                    ) {
                        Icon(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(all = 3.dp),
                            painter = painterResource(R.drawable.ic_fast_forward),
                            contentDescription = ""
                        )
                    }
                }


                Spacer(modifier = modifier.width(20.dp))

                Row(
                    modifier = modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(horizontal = 10.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        "00:20",
                        modifier = modifier.align(Alignment.CenterVertically),
                        style = MaterialTheme.typography.labelSmall.copy(
                            color = colorResource(R.color.white)
                        ),
                    )
                    LinearProgressIndicator(
                        progress = {
                            0.1f
                        },
                        trackColor = Color.DarkGray,
                        color = Color.White,
                        modifier = modifier
                            .align(Alignment.CenterVertically),
                    )
                    Text(
                        "02:20",
                        modifier = modifier.align(Alignment.CenterVertically),
                        style = MaterialTheme.typography.labelSmall.copy(
                            color = colorResource(R.color.white)
                        ),
                    )
                }

            }

        }

        Spacer(
            modifier = modifier
                .height(15.dp)
                .background(color = Color.Red)
        )
        HorizontalDivider()
        Row(
            modifier = modifier
                .height(50.dp)
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_volume),
                modifier = modifier.size(25.dp),
                contentDescription = ""
            )
            Spacer(modifier = modifier.width(7.dp))
            LinearProgressIndicator(
                progress = {
                    0.1f
                },
                trackColor = Color.DarkGray,
                color = Color.White,
                modifier = modifier
                    .align(Alignment.CenterVertically)
                    .width(100.dp),
            )

            Spacer(modifier = modifier.weight(1f))

            Box(
                modifier.clickable {

                },
            ) {
                Icon(
                    painterResource(R.drawable.ic_arrow_one_replay),
                    modifier = Modifier.size(25.dp),
                    contentDescription = null,
                )
            }

            Spacer(modifier = modifier.width(17.dp))

            Box(
                modifier.clickable {

                },
            ) {
                Icon(
                    painterResource(R.drawable.ic_arrows_shuffle),
                    modifier = Modifier.size(25.dp),
                    contentDescription = null,
                )
            }

            Spacer(modifier = modifier.width(17.dp))

            Box(
                modifier.clickable {

                },
            ) {
                Icon(
                    painterResource(R.drawable.icon_arrows_replay),
                    modifier = Modifier.size(25.dp),
                    contentDescription = null,
                )
            }


        }

        HorizontalDivider()

        MusicDetailSubContainer()

    }
}


@Preview(
    showBackground = true,
    backgroundColor = 0x00FFFFFF
)
@Composable
fun MusicDetailPreview() {
    Studio100PercentTheme {
        MusicDetail()
    }
}


@Composable
fun MusicDetailSubContainer() {
    val tabs = listOf("가사", "댓글", "리스트")
    var selectedTab by rememberSaveable { mutableIntStateOf(0) }

    Column(modifier = Modifier.padding(horizontal = 20.dp)) {
        TabRow(
            selectedTabIndex = selectedTab,
            contentColor = Color.White,
            indicator = { tabPositions ->
                TabRowDefaults.SecondaryIndicator(
                    modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTab]),
                    color = Color.White,
                )

            }
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTab == index,
                    onClick = { selectedTab = index },
                    text = { Text(title) },
                )
            }
        }

        when (selectedTab) {
            0 -> Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 20.dp)
            ) {
                Text(
                    "I do the same thing I told you that I never would " +
                            "I told you I'd change, even when I knew I never could " +
                            "I know that I can't find nobody else as good as you " +
                            "I need you to stay, need you to stay, hey (oh) I get drunk, " +
                            "wake up, I'm wasted still I realize the time that I wasted here " +
                            "I feel like you can't feel the way I feel Oh, " +
                            "I'll be f- up if you can't be right here Oh, ooh-woah" +
                            " (oh, ooh-woah, ooh-woah) Oh, ooh-woah (oh, ooh-woah, ooh-woah) Oh, " +
                            "ooh-woah (oh, ooh-woah, ooh-woah) Oh, I'll be f- up if you can't be " +
                            "right here I do the same thing I told you that I never would I told you " +
                            "I'd change, even when I knew I never could " +
                            "I know that I can't find nobody else as good as you I need you to stay, need you to stay, hey I do the same thing I told you that I never would I told you I'd change, even when I knew I never could I know that I can't find nobody else as good as you I need you to stay, need you to stay, hey When I'm away from you, I miss your touch (ooh) You're the reason I believe in love It's been difficult for me to trust (ooh) And I'm afraid that I'ma f- it up Ain't no way that I can leave you stranded 'Cause you ain't ever left me empty-handed And you know that I know that I can't live without you So, baby, stay Oh, ooh-woah (oh, ooh-woah, ooh-woah) Oh, ooh-woah (oh, ooh-woah, ooh-woah) Oh, ooh-woah (oh, ooh-woah, ooh-woah) I'll be f- up if you can't be right here I do the same thing I told you that I never would I told you I'd change, even when I knew I never could I know that I can't find nobody else as good as you I need you to stay, need you to stay, hey I do the same thing I told you that I never would I told you I'd change, even when I knew I never could I know that I can't find nobody else as good as you I need you to stay, need you to stay, hey Woah-oh I need you to stay, need you to stay, hey"
                )
            }

            1 -> Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.Yellow)
            )

            2 -> Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.Magenta)
            )
        }
    }
}