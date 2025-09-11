//
//  ContentView.swift
//  MediAlert
//
//  Created by Elvis Alain Calzada Trinidad on 10/09/25.
//

import SwiftUI

struct ContentView: View {
    var body: some View {
        NavigationStack {
            VStack(spacing: 20) {
                
                // Logo
                Image("cmica_logo")
                    .resizable()
                    .scaledToFit()
                    .frame(width: 200, height: 80)
                    .padding(.top, 40)
                
                // Título
                Text("MediAlert")
                    .font(.title2)
                    .fontWeight(.semibold)
                    .foregroundColor(.blue)
                
                // Subtítulo
                HStack(spacing: 8) {
                    Image(systemName: "doc.text")
                        .font(.title3)
                    Text("Registro")
                        .font(.title3)
                        .fontWeight(.semibold)
                }
                
                Text("Ingresa los datos solicitados:")
                    .font(.subheadline)
                    .foregroundColor(.gray)
                
                // Campos de texto
                VStack(spacing: 14) {
                    TextField("Nombre(s)", text: .constant(""))
                        .textFieldStyle(.roundedBorder)
                    
                    TextField("Apellidos", text: .constant(""))
                        .textFieldStyle(.roundedBorder)
                    
                    Menu {
                        Button("Español") {}
                        Button("English") {}
                    } label: {
                        HStack {
                            Text("Selecciona idioma")
                                .foregroundColor(.gray)
                            Spacer()
                            Image(systemName: "chevron.down")
                                .foregroundColor(.gray)
                        }
                        .padding()
                        .background(
                            RoundedRectangle(cornerRadius: 8)
                                .stroke(Color.gray.opacity(0.3))
                        )
                    }
                    
                    TextField("Teléfono", text: .constant(""))
                        .textFieldStyle(.roundedBorder)
                    
                    TextField("Contacto de emergencia (Teléfono)", text: .constant(""))
                        .textFieldStyle(.roundedBorder)
                }
                .padding(.horizontal)
                
                // Navegar a la segunda pantalla (mockup geolocalización)
                NavigationLink {
                    GeolocalizacionView()
                } label: {
                    Text("Crear Cuenta")
                        .frame(maxWidth: .infinity)
                        .padding()
                        .foregroundColor(.white)
                        .background(Color.blue)
                        .cornerRadius(8)
                }
                .padding(.horizontal)
                .padding(.top, 10)
                
                Spacer()
            }
        }
    }
}

#Preview {
    ContentView()
}
