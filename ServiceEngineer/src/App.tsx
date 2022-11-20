import React from 'react';
import './App.css';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import { builtinModules } from 'module';
import LoginPage from "./components/LoginPage";
import SecondPage from "./components/SecondPage";
import Header from "./components/Header";
import Home from "./components/Home";
import Searchlist_3 from "./components/Searchlist_3";
import FindHouse_5 from "./components/FindHouse_5";
import Detail_6 from './components/Detail_6';
import {BrowserRouter as Router,Route,Routes} from "react-router-dom";


//全体はRouter,ルーティングしたいものはRoutes,RouteはURL指定
function App() {
  return (
    <Router>
      <div className="App">
        <Header/>
        
        <Routes>
          <Route path = "/" element={<LoginPage/>}/>
          <Route path = "/FindEvent" element={<SecondPage/>}/>
          <Route path = "/Home" element={<Home/>}/>
          <Route path = "/Searchlist" element={<Searchlist_3/>}/>
          <Route path = "/FindHouse" element={<FindHouse_5/>}/>
          <Route path = "/Detail" element={<Detail_6/>}/>

        </Routes>
        
     

      </div>
    </Router>
  );
}

export default App;