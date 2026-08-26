"use client";

import {
  Card,
  CardHeader,
  CardAction,
  CardTitle,
  CardDescription,
  CardFooter,
} from "@/components/ui/card";
import {
  CarouselContent,
  CarouselItem,
  CarouselNext,
  CarouselPrevious,
  Carousel,
} from "@/components/ui/carousel";
import { Button } from "@base-ui/react";
import { Badge } from "lucide-react";
import Image from "next/image";
import { useListing } from "../hooks/useListing";

interface CarouselItems {
  data: CarouselItem[];
}

interface CarouselItem {
  image: string;
  body: string;
  title: string;
  category?: string;
}

interface Listing {
  name: string;
  description: string;
  price: number;
  quantity: number;
  status: string;
  categories?: string[];
}

export function CarouselAuto() {
  const { data: listings, error, isPending } = useListing();

  console.log("Listings", useListing());
  console.log("Error", error);
  console.log("Data", listings);

  return (
    <Carousel
      opts={{
        loop: true,
      }}
    >
      <CarouselContent>
        {listings.map((listing: Listing) => {
          return (
            <CarouselItem
              className="basis-full md:basis-1/2 lg:basis-1/4"
              key={`${listing.name}`}
            >
              <Card className="relative mx-auto w-full max-w-sm pt-0">
                <div className="absolute inset-0 z-30 aspect-video bg-black/35" />
                <Image
                  src={`/logo.png`}
                  alt="Event cover"
                  className="relative z-20 aspect-video w-full object-cover brightness-60 grayscale dark:brightness-40"
                  width={50}
                  height={50}
                />
                <CardHeader>
                  <CardAction>
                    <Badge>Featured</Badge>
                  </CardAction>
                  <CardTitle>{listing.name}</CardTitle>
                  <CardDescription>{listing.description}</CardDescription>
                </CardHeader>
                <CardFooter>
                  <Button className="w-full">View</Button>
                </CardFooter>
              </Card>
            </CarouselItem>
          );
        })}
      </CarouselContent>
      <CarouselPrevious className="rtl:rotate-180" />
      <CarouselNext className="rtl:rotate-180" />
    </Carousel>
  );
}
