import React from "react";
import { useParams } from "react-router-dom";
import Header from "../components/Header";

export default function Image(props) {
  let { id } = useParams();

  return (
    <div className="box">
      <Header />
      <div>
        <img src="http://localhost:8080/storage/images/1"></img>
      </div>
    </div>
  );
}
