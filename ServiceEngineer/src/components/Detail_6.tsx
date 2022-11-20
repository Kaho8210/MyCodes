import React from 'react';
import './App.css';
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';
import Image from "./2225637_m.jpg";

export const Detail_6=()=>{
  return (
    <div>
      <div style={{margin: 'center', padding: '20px'}}>
        <Card>
          <img src={Image} />
          <Card.Body>
            <Card.Title>空き家1</Card.Title>
            <Card.Text>
              <br></br>
              詳細
              築４年
            </Card.Text>
          </Card.Body>
        </Card>
      </div>
      <div style={{textAlign: 'center'}}>
        <Button variant="primary">予約状態を見る</Button>
      </div>
    </div>
  );
}

export default Detail_6;