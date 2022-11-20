import React from 'react';
import { Link } from "react-router-dom";

const Header = () => {
  return (
    <header>
    <div className = "logo">
        <h3></h3>
    </div>

    <nav>
      <ul>
        <li>
          <Link to ="/Home">ホーム</Link>
        </li>
    
        <li>
          <Link to = "/FindEvent">イベント</Link>
        </li>

        <li>
          <a href = "#">マイページ</a>
        </li>

        <li>
          <a href = "#">お知らせ</a>
        </li>

        <li>
          <Link to ="/">ログイン画面に戻る</Link>
        </li>
      </ul>
    </nav>
    </header>
  )
};

export default Header