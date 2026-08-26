import { MainSection } from "../features/auth/components/MainSection";
import { TopNavBar } from "../features/auth/components/TopNavBar";
import { MainPageCatalog } from "../features/listings/components/MainPageCatalog";

export default function HomePage() {
  return (
    <main className="flex flex-col h-full">
      <TopNavBar />
      <MainSection />
      <MainPageCatalog />
    </main>
  );
}
