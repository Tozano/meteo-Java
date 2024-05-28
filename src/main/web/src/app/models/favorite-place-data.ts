import {WeatherApiData} from "./weatherApiData";

export interface FavoritePlaceData {
  id?: number,
  surname: string,
  cityName?: string,
  stateCode?: string,
  countryCode?:string,
  pos?: {
    lat: number,
    lon: number
  },
  user?: {
    id:number
  }
  weatherData?: WeatherApiData,
}
