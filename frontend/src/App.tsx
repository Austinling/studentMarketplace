import { useState, useEffect } from "react";
import axios from "axios";

import "./App.css";

function App() {
    const baseURL = import.meta.env.VITE_API_URL;
    const [data,setData] = useState({});

    useEffect(()=>{
      const fetchData = async() => {
        try{
          const response = await axios.get(baseURL);
          setData(response.data);
        }

      }

    })
}

export default App;
