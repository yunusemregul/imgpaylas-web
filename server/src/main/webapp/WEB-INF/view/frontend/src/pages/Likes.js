import React from "react";
import Header from "../components/Header";
import DivBackground from "../components/DivBackground";

export default function Likes() {
  return (
    <div className="box" style={{ height: "auto" }}>
      <Header title="Beğendiklerin" />
      <DivBackground backgroundColor="#444444"></DivBackground>
    </div>
  );
}
