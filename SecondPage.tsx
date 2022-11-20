import React from 'react'
import Button from 'react-bootstrap/Button';
import { Link } from "react-router-dom";

const SecondPage = () => {
  return (
    <div>
      <h2 style={{textAlign: 'center' , paddingTop: '100px'}}>
        イベント
      </h2>

      <div style={{textAlign: 'center' , paddingTop: '180px'}}>
        <Button href="/FindHouse">イベントの開催</Button>
      </div>

      <div style={{textAlign: 'center' , paddingTop: '220px'}}>
        <Button href="/Searchlist">イベントの検索</Button>
      </div>
    

    </div>
  )
}

export default SecondPage;