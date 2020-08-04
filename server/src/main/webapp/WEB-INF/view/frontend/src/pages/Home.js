import axios from "axios";
import React, { useEffect, useState } from "react";
import DivBackground from "../components/DivBackground";
import Header from "../components/Header";
import ImageBox from "../components/ImageBox";
import ResponsiveMasonry from "../components/ResponsiveMasonry";

export default function Home() {
  const [images, setImages] = useState([]);
  const [likes, setLikes] = useState([]);

  /*
    images: database deki tüm fotoğraflar
    likes: kullanıcının beğendiği fotoğraflar
  */

  useEffect(() => {
    axios.get("/api/v1/image/all").then((res) => {
      if (res.status === 200) {
        setImages(res.data);
      }
    });
    axios.get("/api/v1/like/my_likes").then((res) => {
      if (res.status === 200) {
        setLikes(res.data);
      }
    });
    return () => {};
  }, []);

  return (
    <div className="box" style={{ height: "auto" }}>
      <Header title="Ana Sayfa" />
      <DivBackground backgroundColor="#444444">
        <ResponsiveMasonry>
          {images.map((image) => {
            return (
              <ImageBox
                key={image.id}
                data={image}
                userLiked={likes.includes(image.id)}
              />
            );
          })}
        </ResponsiveMasonry>
      </DivBackground>
    </div>
  );
}
