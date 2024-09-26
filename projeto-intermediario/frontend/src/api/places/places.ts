import "@react-google-maps/api";

export const fetchPlaces = async (local: string, map: google.maps.Map | null) => {
  try {
    const response = await fetch(`/api/maps/geocode?address=${encodeURIComponent(local)}`);

    if (response.ok) {
      const data = await response.json();

      if (data.lat && data.lng) {
        const center = { lat: data.lat, lng: data.lng };

        if (map) {
          map.panTo(center);
          map.setZoom(14);
        }
      } else {
        console.error("Erro ao buscar coordenadas");
      }
    } else {
      console.error("Erro na resposta da API do backend");
    }
  } catch (error) {
    console.error("Erro na busca de coordenadas: ", error);
  }
};
