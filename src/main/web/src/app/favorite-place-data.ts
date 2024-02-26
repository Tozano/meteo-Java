import {WeatherApiData} from "./weatherApiData";

export interface FavoritePlaceData {
  surname: string,
  cityName?: string,
  pos?: {
    lat:number,
    lon:number
  },
  weatherData?: WeatherApiData,
}
