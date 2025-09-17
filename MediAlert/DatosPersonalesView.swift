//
//  DatosPersonalesView.swift
//  MediAlert
//
//  Created by Elvis Alain Calzada Trinidad on 17/09/25.
//

import SwiftUI

struct DatosPersonalesView: View {
    var body: some View {
        VStack(spacing: 16) {

            // Header propio (sin usar nav bar)
            HStack {
                Label("Datos Personales", systemImage: "info.circle")
                    .font(.title3.weight(.semibold))
                Spacer()
                HStack(spacing: 14) {
                    Image(systemName: "cross.case") // botiquín
                    Image(systemName: "globe")       // idioma
                }
                .font(.title3)
            }
            .padding(.horizontal)
            .padding(.top, 12)

            // Avatar + nombre
            HStack(spacing: 12) {
                ZStack {
                    Circle().fill(Color(.secondarySystemBackground))
                    // Si agregas un asset "avatar", pon Image("avatar")
                    Image(systemName: "person.crop.circle.fill")
                        .resizable()
                        .scaledToFit()
                        .foregroundStyle(.gray.opacity(0.7))
                        .padding(6)
                }
                .frame(width: 56, height: 56)

                Text("Camila")
                    .font(.title3.weight(.semibold))
                Image(systemName: "pencil")
                    .foregroundStyle(.primary)
                Spacer()
            }
            .padding(.horizontal)

            // Lista de chips
            ScrollView {
                VStack(spacing: 14) {
                    ChipRow(titulo: "Nombre:", valor: "Camila")
                    ChipRow(titulo: "Apellidos:", valor: "Juárez", editable: true)
                    ChipRow(titulo: "Teléfono:", valor: "2354687958", editable: true)
                    ChipRow(titulo: "Contacto Emergencias:", valor: "2368545879", editable: true)
                    ChipRow(titulo: "Dirección:", valor: "Avenida José María", editable: true)
                    ChipRow(titulo: "Sexo:", valor: "Mujer", editable: true)
                    ChipRow(titulo: "Peso:", valor: "60 Kg", editable: true)
                    ChipRow(titulo: "Edad:", valor: "30 años", editable: true)
                    ChipRow(titulo: "Tipo de sangre:", valor: "O+", editable: true)
                    ChipRow(titulo: "Diagnóstico:", valor: "Asma", editable: true)
                    ChipRow(titulo: "Alergias:", valor: "Polvo, polen, ...", editable: true)
                }
                .padding(.horizontal)
                .padding(.bottom, 8)
            }

            // Tab bar (mock, estático)
            HStack(spacing: 30) {
                NavigationLink{
                    GeolocalizacionView()
                } label: {
                    Image(systemName: "house.fill")
                }
                // Image(systemName: "house.fill")
                Image(systemName: "bell.fill")
                ZStack {
                    Circle().fill(Color(.systemBackground))
                        .frame(width: 56, height: 56)
                        .shadow(color: .black.opacity(0.15), radius: 6, y: 2)
                    Text("SOS")
                        .font(.headline)
                }
                Image(systemName: "book.fill")
                NavigationLink{
                    DatosPersonalesView()
                } label: {
                    Image(systemName: "person.crop.circle.fill")
                }
            }
            .font(.title2)
            .padding(.vertical, 10)
        }
        .navigationBarBackButtonHidden(true)
        .toolbar(.hidden, for: .navigationBar)
    }
}

/// Chip con fondo tipo cápsula, etiqueta azul y lápiz opcional
struct ChipRow: View {
    let titulo: String
    let valor: String
    var editable: Bool = false

    var body: some View {
        HStack {
            HStack(spacing: 2) {
                Text(titulo)
                    .fontWeight(.semibold)
                    .foregroundStyle(Color.blue.opacity(0.9))
                Text(valor)
            }
            Spacer()
            if editable {
                Image(systemName: "pencil")
                    .foregroundStyle(.secondary)
            }
        }
        .padding(.horizontal, 14)
        .padding(.vertical, 12)
        .background(
            Capsule()
                .fill(Color(.systemGray5))
                .shadow(color: .black.opacity(0.08), radius: 4, y: 2)
        )
    }
}

#Preview {
    NavigationStack { DatosPersonalesView() }
}
