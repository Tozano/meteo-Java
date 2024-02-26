export interface WeatherApiData {
  coord?: {
    lon?: number;
    lat?: number;
  }
  name?: string;
  weather: [
    {
      description: string
    }
  ];
  main: {
    temp:number;
  }
}
