export interface WeatherApiData {
  lon?: number;
  lat?: number;
  city?: string;
  weather: [
    {
      description: string
    }
  ];
  temperature:number;
}
