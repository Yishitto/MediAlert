package com.a01738457.cmica

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GeolocalizacionScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            // Header
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .padding(top = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "MediAlert",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.weight(1f))
                Row(horizontalArrangement = Arrangement.spacedBy(14.dp)) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_cross_case),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.ic_globe),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }

            // Buscador (mock)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .padding(top = 8.dp)
                    .background(
                        color = MaterialTheme.colorScheme.surfaceVariant,
                        shape = RoundedCornerShape(12.dp)
                    )
                    .padding(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = null,
                    modifier = Modifier.size(28.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Buscar lugares",
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.weight(1f))
            }

            // Mapa
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .height(180.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(MaterialTheme.colorScheme.surfaceVariant)
            ) {
                val mapPainter = painterResource(id = R.drawable.mapa)
                Image(
                    painter = mapPainter,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.matchParentSize()
                )
            }

            // Título sección
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .padding(top = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Hospitales más cercanos",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.weight(1f))
            }

            // Lista de 3 hospitales más cercanos
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                HospitalRowMock(
                    imageRes = R.drawable.hospital1,
                    nombre = "Hospital Angelopolitano",
                    tipo = "Hospital privado",
                    detalle = "Abierto las 24 horas\n222 246 5688"
                )
                HospitalRowMock(
                    imageRes = R.drawable.hospital2,
                    nombre = "Hospital Puebla",
                    tipo = "Hospital privado",
                    detalle = "Abierto las 24 horas\n222 594 0600"
                )
                HospitalRowMock(
                    imageRes = R.drawable.hospital3,
                    nombre = "Hospital General de Cholula",
                    tipo = "Hospital general",
                    detalle = "Abierto las 24 horas\n222 214 4300"
                )
            }
        }

        // Tab bar (mock, estático)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_house_filled),
                contentDescription = null,
                modifier = Modifier.size(28.dp)
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_bell_filled),
                contentDescription = null,
                modifier = Modifier.size(28.dp)
            )
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(56.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.background)
                    .shadow(6.dp, CircleShape)
            ) {
                Text(
                    text = "SOS",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Icon(
                painter = painterResource(id = R.drawable.ic_book_filled),
                contentDescription = null,
                modifier = Modifier.size(28.dp)
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_person_circle_filled),
                contentDescription = null,
                modifier = Modifier.size(28.dp)
            )
        }
    }
}

@Composable
fun HospitalRowMock(
    imageRes: Int,
    nombre: String,
    tipo: String,
    detalle: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .size(100.dp)
            .padding(4.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.background)
            .shadow(3.dp, RoundedCornerShape(12.dp)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(width = 85.dp, height = 70.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(MaterialTheme.colorScheme.surfaceVariant)
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.matchParentSize()
            )
        }
        Spacer(modifier = Modifier.width(12.dp))
        Column(
            verticalArrangement = Arrangement.spacedBy(3.dp),
            modifier = Modifier.weight(1f)
        ) {
            Text(text = nombre, fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
            Text(text = tipo, fontSize = 12.sp, color = Color.Gray)
            Text(text = detalle, fontSize = 14.sp, color = Color.Gray)
        }
        Icon(
            painter = painterResource(id = R.drawable.ic_localization),
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GeolocalizacionScreenPreview() {
    GeolocalizacionScreen()
}