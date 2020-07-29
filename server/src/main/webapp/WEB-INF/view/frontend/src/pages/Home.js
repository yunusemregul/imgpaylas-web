import React, { useEffect, useState } from "react";
import DivBackground from "../components/DivBackground";
import Header from "../components/Header";
import axios from "axios";
import Masonry from "react-masonry-css";
import ImageBox from "../components/ImageBox";

export default function Home() {
  const [images, setImages] = useState([]);

  useEffect(() => {
    /*axios.get("/api/v1/image/all").then((res) => {
      if (res.status === 200) {
        setImages(res.data);
      }
    });*/
    setImages([
      {
        id: 1,
        desc: "bu sistemin database şeması",
        url: "http://localhost:8080/images/1/1",
        user: 1,
      },
      {
        id: 2,
        desc: "staj başvuru formum",
        url: "http://localhost:8080/images/1/2",
        user: 1,
      },
      {
        id: 3,
        desc: "github profilim",
        url: "http://localhost:8080/images/1/3",
        user: 1,
      },
      {
        id: 4,
        desc: "bazen internetimiz",
        url: "http://localhost:8080/images/1/4",
        user: 1,
      },
      {
        id: 5,
        desc: "kocaeli minik",
        url: "http://localhost:8080/images/1/5",
        user: 1,
      },
      {
        id: 6,
        desc: "kocaeli minik",
        url: "http://localhost:8080/images/14/6",
        user: 14,
      },
    ]);
    return () => {};
  }, []);

  return (
    <div className="box">
      <Header />
      <DivBackground color="#F3F4F5">
        <Masonry
          breakpointCols={4}
          className="my-masonry-grid"
          columnClassName="my-masonry-grid_column"
        >
          {images.map((image) => {
            return (
              <ImageBox key={image.id} desc={image.desc} img={image.url} />
            );
          })}
        </Masonry>
      </DivBackground>
    </div>
  );
}
