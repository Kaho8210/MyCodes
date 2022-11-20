import React from 'react';
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';
import Image1 from "./components/2225637_m.jpg";
import Image2 from "./components/5034544_s.jpg";
import Image3 from "./components/空き家3.jpg";

export const FindHouse_5= () =>  {
  return (
    <div>
    <h2 style={{textAlign: 'center', paddingTop: '30px'}}>空き家検索</h2>
    <div style={{padding: '50px',width: '100%' }}>
    <Card>
    <img src={Image1}/>
      <Card.Body>
        <Card.Title>空き家1</Card.Title>
        <Card.Text>
          ポイント
        </Card.Text>
        <Button variant="primary">詳細を見る</Button>
      </Card.Body>
    </Card>
    <br></br>
    <Card>
      <img src={Image2}/>
      <Card.Body>
        <Card.Title>空き家2</Card.Title>
        <Card.Text>
          ポイント
        </Card.Text>
        <Button variant="primary">詳細を見る</Button>
      </Card.Body>
    </Card>
    <br></br>
    <Card>
    <img src={Image3}/>
      <Card.Body>
        <Card.Title>空き家3</Card.Title>
        <Card.Text>
          ポイント
        </Card.Text>
        <Button variant="primary">詳細を見る</Button>
      </Card.Body>
    </Card>
    </div>
    </div>
  );
}

export default FindHouse_5;